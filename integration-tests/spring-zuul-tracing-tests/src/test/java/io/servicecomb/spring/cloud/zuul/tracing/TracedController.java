/*
 * Copyright 2017 Huawei Technologies Co., Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.servicecomb.spring.cloud.zuul.tracing;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import io.servicecomb.provider.rest.common.RestSchema;
import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

@RestSchema(schemaId = "tracedController")
@RequestMapping("/rest")
public class TracedController {
  private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  @RequestMapping(value = "/blah", method = GET, produces = TEXT_PLAIN_VALUE)
  public String blah() {
    logger.info("in /blah");

    return "blah";
  }

  @RequestMapping(value = "/oops", method = GET, produces = TEXT_PLAIN_VALUE)
  public String oops() {
    logger.info("in /oops");

    throw new IllegalStateException("oops");
  }
}
