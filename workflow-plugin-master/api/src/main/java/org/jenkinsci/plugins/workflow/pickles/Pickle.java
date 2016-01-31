/*
 * The MIT License
 *
 * Copyright (c) 2013-2014, CloudBees, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.jenkinsci.plugins.workflow.pickles;

import com.google.common.util.concurrent.ListenableFuture;
import hudson.FilePath;

import java.io.Serializable;

/**
 * Handle value objects to replace another stateful objects that cannot be serialized on its own,
 * such as {@link FilePath}.
 *
 * @author Kohsuke Kawaguchi
 */
public abstract class Pickle implements Serializable {
    /**
     * Start preparing rehydration of this value, and when it's ready or fail, report that to the
     * given call.
     * An implementation should return quickly and avoid acquiring locks in this method itself (as opposed to the future).
     */
    public abstract ListenableFuture<?> rehydrate();

    private static final long serialVersionUID = 1L;
}
