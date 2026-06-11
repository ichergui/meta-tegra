SUMMARY = "Jetson expansion header configuration tool"
DESCRIPTION = "Python scripts for reconfiguring Jetson expansion headers via device tree overlays"
L4T_DEB_COPYRIGHT_MD5 = "01542784ed6e489cd77bae5aafcddd6c"

L4T_DEB_TRANSLATED_BPN = "nvidia-l4t-jetson-io"

require recipes-bsp/tegra-binaries/tegra-debian-libraries-common.inc

inherit python3native

DEPENDS += "virtual/dtb dtc-native"

MAINSUM = "70d8b48d9a120aa75574b9ebdc359f82c2a9ad68e532a7d3dcec18465dfff9b8"

JETSON_IO_BASE = "/opt/nvidia/jetson-io"
JETSON_IO_DTBDIR = "${datadir}/jetson-io"

EXTERNAL_KERNEL_DEVICETREE ?= "${@'${RECIPE_SYSROOT}/boot/devicetree' if d.getVar('PREFERRED_PROVIDER_virtual/dtb') else ''}"

SRC_URI += "file://0001-Jetson-board.py-OE4T-adaptations-for-DTB-paths.patch"

python do_copy_jetson_io_dtbs() {
    import glob
    import oe4t.dtbutils
    import os

    dtbdir = os.path.join(d.getVar('B'), 'dtb')
    bb.utils.mkdirhier(dtbdir)

    dtbs = d.getVar('KERNEL_DEVICETREE')
    if not dtbs:
        bb.fatal('KERNEL_DEVICETREE is not set')

    oe4t.dtbutils.copy_dtb_files(dtbs, dtbdir, d)

    extern_root = d.getVar('EXTERNAL_KERNEL_DEVICETREE')
    if extern_root and os.path.isdir(extern_root):
        dtbos = [os.path.basename(f) for f in glob.glob(os.path.join(extern_root, '*.dtbo'))]
        if dtbos:
            oe4t.dtbutils.copy_dtb_files(' '.join(dtbos), dtbdir, d)

    if not glob.glob(os.path.join(dtbdir, '*')):
        bb.fatal('No device tree files staged into %s' % dtbdir)
}
do_copy_jetson_io_dtbs[dirs] = "${B}"
do_copy_jetson_io_dtbs[depends] += "${@'virtual/dtb:do_populate_sysroot' if d.getVar('PREFERRED_PROVIDER_virtual/dtb') else ''}"
do_copy_jetson_io_dtbs[vardeps] += "KERNEL_DEVICETREE EXTERNAL_KERNEL_DEVICETREE"

addtask copy_jetson_io_dtbs after do_patch before do_install

do_install() {
    install -d ${D}${JETSON_IO_BASE}/
    cp -R --no-dereference --preserve=links,mode,timestamps ${S}${JETSON_IO_BASE}/* ${D}${JETSON_IO_BASE}/

    install -d ${D}${JETSON_IO_DTBDIR}
    install -m 0644 ${B}/dtb/* ${D}${JETSON_IO_DTBDIR}/
}

FILES:${PN} += "${JETSON_IO_BASE} ${JETSON_IO_DTBDIR}"

RDEPENDS:${PN} += "\
    python3 \
    dtc \
    util-linux-lsblk \
    util-linux-mount \
    util-linux-mountpoint \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"
