CUDA_PKG = "${BPN}"

require cuda-shared-binaries.inc

MAINSUM = "8009458c58b6cd0e25d86262521aa2365b99ba8c4850c41839b923f644a335ec"
MAINSUM:x86-64 = "6ba26bdd386d3dfd667cac1cd0cf305558d1d1b52173420976ac572817e57401"

BBCLASSEXTEND = "native nativesdk"
