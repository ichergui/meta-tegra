LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://Tegra_Software_License_Agreement-Tegra-Linux.txt;md5=2d48d198004cfe9c3bc0df31c1b89805 \
                    file://nv_tegra/LICENSE.brcm_patchram_plus;md5=38fb07f0dacf4830bc57f40a0fb7532e"

SRC_URI = "\
    ${L4T_URI_BASE}/${L4T_BSP_PREFIX}_Linux_R${L4T_VERSION}_aarch64.tbz2 \
"

SRC_URI[sha256sum] = "1cc07ea946df064b1eb5d6ba8bc289d84e6b9f437b5f538e95a0d2ae6639e601"

inherit l4t_bsp dos2unix

# Override convert_crlf_to_lf task to only convert "*.cfg", "*.dts*" files
do_convert_crlf_to_lf () {
	find ${S} -type f "-(" -name "*.cfg" -o -name "*.dts*" "-)" -exec dos2unix {} \;
}

S = "${TMPDIR}/work-shared/L4T-${L4T_BSP_ARCH}-${PV}-${PR}/Linux_for_Tegra"
B = "${WORKDIR}/build"

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

COMPATIBLE_MACHINE = "tegra"

do_preconfigure() {
    :
}