
package com.core.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class CoreServiceController
{
   @RequestMapping("/")
   public boolean testService()
   {
      return true;
   }
}
