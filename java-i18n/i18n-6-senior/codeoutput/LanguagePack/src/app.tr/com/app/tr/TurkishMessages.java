package com.app.tr;

import com.app.i18n.spi.MessagesProvider;
import java.util.Locale;
import java.util.spi.AbstractResourceBundleProvider;

public class TurkishMessages extends AbstractResourceBundleProvider
                             implements MessagesProvider {
    @Override
    protected String toBundleName(String baseName, Locale locale) {
        return "com.app.tr.Messages_" + locale.getLanguage();  // own package: no split
    }
}
