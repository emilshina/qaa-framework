package com.github.emilshina.listeners;

import lombok.extern.slf4j.Slf4j;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import static com.github.emilshina.utils.AttachmentUtils.attachUri;

/**
 * Listeners for test methods.
 */

@Slf4j
public class TestListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(final IInvokedMethod method, final ITestResult testResult) {
        if (method.isTestMethod()) {
            log.info("METHOD NAME: {} ", method.getTestMethod().getMethodName());
        }
    }

    @Override
    public void afterInvocation(final IInvokedMethod method, final ITestResult testResult) {
        if (method.isTestMethod()) {
            final String fileName = String.format("http://localhost:4444/video/%s.mp4",
                    testResult.getAttribute("sessionId"));
            attachUri("Video", fileName);
        }
    }
}
