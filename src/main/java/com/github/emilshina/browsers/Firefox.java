package com.github.emilshina.browsers;

import io.github.sskorol.core.Browser;

/**
 * Implementation of Browser interface for Firefox browser.
 */

public class Firefox implements Browser {

    public Name name() {
        return Name.Firefox;
    }
}
