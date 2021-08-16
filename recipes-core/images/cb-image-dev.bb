SUMMARY = "Castboard image for Development purposes"
LICENSE="MIT"

# Base this image on core-image-base
include recipes-core/images/core-image-base.bb

COMPATIBLE_MACHINE = "^rpi$"

IMAGE_FEATURES += "debug-tweaks ssh-server-dropbear"

# OUTPUT IMAGE TYPE
IMAGE_FSTYPES = "ext3.xz rpi-sdimg"

# Jwinarske stuff - https://github.com/jwinarske/meta-flutter
BBMASK = "meta-networking/recipes-kernel/wireguard"
DISTRO_FEATURES_remove = " sysvinit"
DISTRO_FEATURES_append = " alsa bluetooth usbhost opengl vulkan systemd wifi"
INIT_MANAGER = "systemd"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = ""
DISTRO_FEATURES_append=" pam selinux"
DISTRO_FEATURES_BACKFILL_CONSIDERED = ""
COMBINED_FEATURES += "alsa "
MACHINE_FEATURES_remove = "apm"
PREFERRED_PROVIDER_jpeg = "libjpeg-turbo"
PREFERRED_PROVIDER_jpeg-native = "libjpeg-turbo-native"
IMAGE_INSTALL += "   packagegroup-core-selinux   avahi-daemon   vulkan-loader vulkan-tools   adwaita-icon-theme-cursors   xdg-user-dirs "
PREFERRED_VERSION_pipewire = "0.3.22"

# RPI Specific Configuration
DISABLE_OVERSCAN = "1"
DISABLE_RPI_BOOT_LOGO = "1"
DISABLE_SPLASH = "1"
ENABLE_SPI_BUS = "1"
ENABLE_I2C = "1"
ENABLE_UART = "0"
SERIAL_CONSOLES = ""

GPU_MEM = "128"
KERNEL_MODULE_AUTOLOAD_raspberrypi4-64 += "i2c-dev i2c-bcm2708"
DISPMANX_OFFLINE = "1"
LINUX_KERNEL_TYPE = "preempt-rt"
CMDLINE_DEBUG = "quiet"
PREFERRED_VERSION_linux-raspberrypi = "5.4.%"

# Flutter
FLUTTER_CHANNEL = "dev"

# Networking Support
IMAGE_INSTALL_append = " hostapd"
IMAGE_INSTALL_append = " dnsmasq"

# Web Servers
IMAGE_INSTALL_append = " nginx"

#
# Scripts
#
#IMAGE_INSTALL_append = " castboard-autorun"

#
# User Facing Software
#

# Flutter Embedders
IMAGE_INSTALL_append = " flutter-pi"
IMAGE_INSTALL_append = " flutter-drm-gbm-backend"

# Flutter Applications
IMAGE_INSTALL_append = " castboard-player"


