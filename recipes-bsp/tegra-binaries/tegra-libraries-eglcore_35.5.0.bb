L4T_DEB_COPYRIGHT_MD5 = "d3617777039321a257aef01439341b02"
DEPENDS = "tegra-libraries-core"

L4T_DEB_TRANSLATED_BPN = "nvidia-l4t-3d-core"

require tegra-debian-libraries-common.inc

MAINSUM = "38043813c3f3a31da46c9ebe05f2267fd10170ab083a11ab2ab5adc3679a69bb"

TEGRA_LIBRARIES_TO_INSTALL = "\
    tegra-egl/libEGL_nvidia.so.0 \
    tegra/libnvidia-eglcore.so.${L4T_VERSION} \
    tegra/libnvidia-glsi.so.${L4T_VERSION} \
    tegra/libnvidia-glvkspirv.so.${L4T_VERSION} \
    tegra/libnvidia-rmapi-tegra.so.${L4T_VERSION} \
    tegra/libnvidia-rtcore.so.${L4T_VERSION} \
"

do_install() {
    install_libraries
    install -d ${D}${datadir}/glvnd/egl_vendor.d
    install -m644 ${S}/usr/lib/aarch64-linux-gnu/tegra-egl/nvidia.json ${D}${datadir}/glvnd/egl_vendor.d/10-nvidia.json
}

pkg_postinst:${PN}() {
    # argus and scf libraries hard-coded to use this path
    install -d $D/usr/lib/aarch64-linux-gnu/tegra-egl
    ln $D${libdir}/libEGL_nvidia.so.0 $D/usr/lib/aarch64-linux-gnu/tegra-egl/
}

FILES:${PN} += "${datadir}/glvnd/egl_vendor.d"
