require cuda-shared-binaries.inc

MAINSUM = "fb092340b981ab7bea21428f34d99e9eb20571de5ff169b3ef338484f007701c"
MAINSUM:x86-64 = "4b511afee31f0ce7f99888a8683ca1035df8676a262f79a10901c27e8b8b5005"
DEVSUM = "9f237fc521f8111a7630eca0b55108b960041884e9bdb3617402e281a55be341"
DEVSUM:x86-64 = "92f0310acfb1e62b52fc962a6431c3be58746c396fa79f7a55a40cc0dc9f8f6b"

RDEPENDS:${PN} = "libcublas libcusparse libnvjitlink"
BBCLASSEXTEND = "native nativesdk"
