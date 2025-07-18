/*
 * Copyright 2014-2015 Groupon, Inc
 * Copyright 2014-2015 The Billing Project, LLC
 *
 * The Billing Project licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.killbill.billing.jaxrs.glue;

import org.killbill.billing.jaxrs.DefaultJaxrsService;
import org.killbill.billing.jaxrs.JaxrsExecutors;
import org.killbill.billing.jaxrs.JaxrsService;
import org.killbill.billing.jaxrs.util.JaxrsUriBuilder;
import org.killbill.billing.platform.api.KillbillConfigSource;
import org.killbill.billing.util.config.definition.JaxrsConfig;
import org.killbill.billing.util.glue.KillBillModule;
import org.skife.config.AugmentedConfigurationObjectFactory;

public class DefaultJaxrsModule extends KillBillModule {

    public DefaultJaxrsModule(final KillbillConfigSource configSource) {
        super(configSource);
    }

    @Override
    protected void configure() {
        final AugmentedConfigurationObjectFactory factory = new AugmentedConfigurationObjectFactory(skifeConfigSource);
        final JaxrsConfig jaxrsConfig = factory.build(JaxrsConfig.class);
        bind(JaxrsConfig.class).toInstance(jaxrsConfig);
        bind(JaxrsUriBuilder.class).asEagerSingleton();
        bind(JaxrsExecutors.class).asEagerSingleton();
        bind(JaxrsService.class).to(DefaultJaxrsService.class).asEagerSingleton();
    }

}
