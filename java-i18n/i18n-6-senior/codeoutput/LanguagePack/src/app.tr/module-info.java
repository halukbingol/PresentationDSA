module app.tr {
    requires app;
    provides com.app.i18n.spi.MessagesProvider with com.app.tr.TurkishMessages;
}
