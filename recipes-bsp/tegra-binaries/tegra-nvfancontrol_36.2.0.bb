DESCRIPTION = "NVIDIA Fan Control"
L4T_DEB_COPYRIGHT_MD5 = "d836242ee6a3086dbeb17bf2dd0578cf"

L4T_DEB_TRANSLATED_BPN = "nvidia-l4t-nvfancontrol"
DEPENDS = "tegra-nvpower"

require tegra-debian-libraries-common.inc

MAINSUM = "c849201880f64e938fc4ba5386ba931a7c816e73e8aa90dad72f8f3c344977ff"

SRC_URI += "\
   file://nvfancontrol.init \
   file://nvfancontrol.service \
"

do_install() {
    install -d ${D}${sbindir}
    install -m 0755 ${B}/usr/sbin/nvfancontrol ${D}${sbindir}/
    install -d ${D}${sysconfdir}/init.d
    install -m 0644 ${B}/etc/nvpower/nvfancontrol/${NVFANCONTROL}.conf ${D}${sysconfdir}/nvfancontrol.conf
    install -m 0755 ${WORKDIR}/nvfancontrol.init ${D}${sysconfdir}/init.d/nvfancontrol
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/nvfancontrol.service ${D}${systemd_system_unitdir}/
}

inherit systemd update-rc.d

INITSCRIPT_NAME = "nvfancontrol"
INITSCRIPT_PARAMS = "defaults"
SYSTEMD_SERVICE:${PN} = "nvfancontrol.service"
RDEPENDS:${PN} = "bash tegra-nvpower tegra-nvpmodel"
PACKAGE_ARCH = "${MACHINE_ARCH}"
