package com.app.i18n.spi;

import java.util.spi.ResourceBundleProvider;

// name required by getBundle: <package of base name>.spi.<Name>Provider
public interface MessagesProvider extends ResourceBundleProvider { }
