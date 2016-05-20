
package com.core.service.test;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring-servlet.xml" })
public class GenericServiceConfigTest
{
   private MockMvc mockMvc;

   @Autowired
   private WebApplicationContext webApplicationContext;

   @Before
   public void setup()
   {
      mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

   }
}
