Feature: Login into Application

Scenario Outline: User needs to login into facebook
Given Initialize the browser with chrome
When User need enter <Username> and <Password>
Then login needs to be happened successfully 
And user fb homepage needs to be displayed
      
  Examples:
   |Username                  | Password   |  
   |pramodrockcy005@gmail.com |Pramod@1996 | 
   |pramodrockcy0054@gmail.com |Pramod@1996 |    