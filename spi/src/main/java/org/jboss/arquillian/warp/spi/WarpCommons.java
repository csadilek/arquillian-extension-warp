/**
 * JBoss, Home of Professional Open Source
 * Copyright 2012, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.arquillian.warp.spi;

import java.lang.annotation.Annotation;

import org.jboss.arquillian.warp.servlet.AfterServlet;
import org.jboss.arquillian.warp.servlet.BeforeServlet;

/**
 * Commons references used for marking events objects Warp execution.
 *
 * @author Lukas Fryc
 */
public final class WarpCommons {

    public static final String NAMESPACE = "org.jboss.arquillian.warp";

    private static final String ENRICHMENT = "X-Arq-Enrichment";
    public static final String ENRICHMENT_REQUEST = ENRICHMENT + "-Request";
    public static final String ENRICHMENT_RESPONSE = ENRICHMENT + "-Response";

    public static final String ENRICHMENT_SEQUENCE_NUMBER = "X-Arq-Enrichment-Id";

    /**
     * Determines whether Warp is in debug mode
     */
    public static boolean debugMode() {
        return System.getProperty("arquillian.debug") != null;
    }

    /**
     * Decides whether given annotation type is {@link WarpLifecycleTest}
     * @param annotationType
     * @return
     */
    public static boolean isWarpLifecycleTest(Class<? extends Annotation> annotationType) {
        return annotationType.getAnnotation(WarpLifecycleTest.class) != null
                || annotationType == BeforeServlet.class
                || annotationType == AfterServlet.class;
    }
}
