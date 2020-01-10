# Spring Plugins demo: an example of promotion services

Code under `oldway` and `newway` packages correspond to, respectively, the legacy ways of implementing business logic, and the new way of doing it with Spring Plugins. Run `ApplicationV1` and `ApplicationV2` to see the difference.  

In daily development, business logic is prune of changes and this makes development and testing harder. Spring plugins partially solves this problem: it converts "adding feature = modifying existent classes" into "adding feature = adding another plugin + its test". We don't change working code, we only add new code to tackle new scenarios, so that **old logic is never touched and will always work as the input data remain the same**. 

