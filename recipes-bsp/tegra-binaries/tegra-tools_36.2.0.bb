DESCRIPTION = "Miscellaneous tools provided by L4T"
L4T_DEB_COPYRIGHT_MD5 = "6a451131481f1bf9e113fb684e99849c"

L4T_DEB_TRANSLATED_BPN = "nvidia-l4t-tools"

require tegra-debian-libraries-common.inc

MAINSUM = "aa9ff1565efae4493d107eed1c0dcef1d883f9a39acefdbd6a9623017790b374"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/usr/bin/tegrastats ${D}${bindir}/
    install -m 0755 ${S}/usr/bin/jetson_clocks ${D}${bindir}/
}

PACKAGES = "${PN}-tegrastats ${PN}-jetson-clocks ${PN}"
ALLOW_EMPTY:${PN} = "1"
RDEPENDS:${PN} = "${PN}-tegrastats ${PN}-jetson-clocks"
FILES:${PN}-tegrastats = "${bindir}/tegrastats"
INSANE_SKIP:${PN}-tegrastats = "ldflags"
FILES:${PN}-jetson-clocks = "${bindir}/jetson_clocks"
RDEPENDS:${PN}-jetson-clocks = "bash"
