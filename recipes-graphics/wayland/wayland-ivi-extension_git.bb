SUMMARY = "Wayland IVI Extension"
DESCRIPTION = "GENIVI Layer Management API based on Wayland IVI Extension"
HOMEPAGE = "http://projects.genivi.org/wayland-ivi-extension"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1f1a56bb2dadf5f2be8eb342acf4ed79"

SRCREV = "db16484a02c418c67914f3e7b32c9343756889be"
SRC_URI = " \
    git://github.com/GENIVI/${BPN}.git;protocol=https;branch=master \
    file://0001-OE-cross-build-fixups.patch \
"
PV = "2.3.1+git${SRCPV}"

S = "${WORKDIR}/git"

DEPENDS = "weston wayland-native"

inherit pkgconfig cmake

FILES:${PN} += " \
    ${libdir}/weston/* \
    ${datadir}/wayland-protocols \
"
