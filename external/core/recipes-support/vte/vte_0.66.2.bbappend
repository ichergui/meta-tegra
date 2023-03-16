FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI:append:tegra = " file://0002-update-cxx-standard-requirement.patch"
