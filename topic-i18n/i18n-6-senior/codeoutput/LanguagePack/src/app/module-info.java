module app {
    exports com.app.i18n.spi;
    uses com.app.i18n.spi.MessagesProvider;      // language packs may provide bundles
}
