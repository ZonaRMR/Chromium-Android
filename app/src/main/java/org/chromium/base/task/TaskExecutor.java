// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.base.task;

/**
 * The Java equivalent of base::TaskExecutor, which can execute Tasks with a specific TaskTraits
 * id. To handle tasks posted via the PostTask API, the TaskExecutor should be registered by
 * calling {@link PostTask.registerTaskExecutor}.
 */
public interface TaskExecutor {
    /**
     * @param traits The TaskTraits that describe the desired TaskRunner.
     * @param task The task to be run with the specified traits.
     * @param delay The delay in milliseconds before the task can be run.
     */
    void postDelayedTask(TaskTraits traits, Runnable task, long delay);

    /**
     * @param traits The TaskTraits that describe the desired TaskRunner.
     * @return The TaskRunner for the specified TaskTraits.
     */
    TaskRunner createTaskRunner(TaskTraits traits);

    /**
     * @param traits The TaskTraits that describe the desired TaskRunner.
     * @return The TaskRunner for the specified TaskTraits.
     */
    SequencedTaskRunner createSequencedTaskRunner(TaskTraits traits);

    /**
     * @param traits The TaskTraits that describe the desired TaskRunner.
     * @return The TaskRunner for the specified TaskTraits.
     */
    SingleThreadTaskRunner createSingleThreadTaskRunner(TaskTraits traits);
}
