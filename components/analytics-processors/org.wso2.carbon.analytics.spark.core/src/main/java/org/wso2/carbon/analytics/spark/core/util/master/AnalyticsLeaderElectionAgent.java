/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.analytics.spark.core.util.master;

import org.apache.spark.deploy.master.LeaderElectable;
import org.apache.spark.deploy.master.LeaderElectionAgent;
import org.wso2.carbon.analytics.spark.core.internal.ServiceHolder;

/**
 * this class elects the new leader if the current leader goes down
 */
public class AnalyticsLeaderElectionAgent implements LeaderElectionAgent {

    private LeaderElectable master;

    public AnalyticsLeaderElectionAgent(LeaderElectable master) {
        this.master = master;
        // System.out.println("################ processing leader");
        ServiceHolder.getAnalyticskExecutor().registerLeaderElectable(master);
    }

    @Override
    public LeaderElectable masterActor() {
        // System.out.println("################ returning master");
        return master;
    }

    @Override
    public void stop() {
        // System.out.println("################ stopping agent");
    }
}