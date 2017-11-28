package com.github.emilshina.browsers;

import io.github.sskorol.core.Browser;

/**
 * Implementation of Browser interface for Chrome browser.
 */

public class Chrome implements Browser {

    public Name name() {
        return Name.Chrome;
    }
}
