SUMMARY = "Jpeg 2000 implementation"
HOMEPAGE = "https://github.com/jasper-software/jasper"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a80440d1d8f17d041c71c7271d6e06eb"

SRC_URI = "git://github.com/jasper-software/jasper.git;protocol=https"
SRCREV = "7d8cfd8ac16d1af9b51e5ccd781e898f0fbf57cc"

S = "${WORKDIR}/git"

inherit cmake

PACKAGECONFIG ??= ""
PACKAGECONFIG[jpeg] = "-DJAS_ENABLE_LIBJPEG=true, -DJAS_ENABLE_LIBJPEG=false, jpeg"
PACKAGECONFIG[opengl] = "-DJAS_ENABLE_OPENGL=true, -DJAS_ENABLE_OPENGL=false, freeglut"

EXTRA_OECMAKE_append = " -DJAS_ENABLE_SHARED=true"

do_install_append() {
    chrpath -d ${D}${bindir}/jasper
    chrpath -d ${D}${bindir}/imginfo
    chrpath -d ${D}${bindir}/imgcmp
    chrpath -d ${D}${libdir}/libjasper.so.*
}