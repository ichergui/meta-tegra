L4T_DEB_COPYRIGHT_MD5 = "03753bf7be89a121c8d3fd11c4267db9"
DEPENDS = "tegra-libraries-core tegra-libraries-eglcore"

L4T_DEB_TRANSLATED_BPN = "nvidia-l4t-3d-core"

require tegra-debian-libraries-common.inc

MAINSUM = "31b5c0de9fc673a540e6c331ae18cb981fc6de1145f4be76419bed0f9de1959b"
MAINSUM:tegra210 = "13fa8733d146999ac1a6e2c37c70c2f4b64988c5bcd5a664f2fda4bb4a04680b"

TEGRA_LIBRARIES_TO_INSTALL = "\
    tegra-egl/libGLESv1_CM_nvidia.so.1 \
    tegra-egl/libGLESv2_nvidia.so.2 \
"