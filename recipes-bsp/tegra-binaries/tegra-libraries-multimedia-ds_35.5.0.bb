L4T_DEB_COPYRIGHT_MD5 = "770b0fc2a5cffa1d2b7eda7393e6b012"
DEPENDS = "tegra-libraries-multimedia glib-2.0 gstreamer1.0-plugins-base"

L4T_DEB_TRANSLATED_BPN = "nvidia-l4t-multimedia"

require tegra-debian-libraries-common.inc

LICENSE += "& MIT & BSD-3-Clause"

MAINSUM = "6bcecffe065e4be945d88e0312f31a1802eaf2d1afcf5e9822e934085fe7354a"

inherit features_check

REQUIRED_DISTRO_FEATURES = "opengl"

TEGRA_LIBRARIES_TO_INSTALL = "\
    tegra/libnvdsbufferpool.so.1.0.0 \
"

do_install() {
    install_libraries
    for libname in nvdsbufferpool; do
	ln -sf lib$libname.so.1.0.0 ${D}${libdir}/lib$libname.so.1
	ln -sf lib$libname.so.1.0.0 ${D}${libdir}/lib$libname.so
    done
}

FILES_SOLIBSDEV = ""
SOLIBS = ".so*"
