> 想了好一会儿，也没有想好名字，忽然想起来了湖。没有原因的，再想大气一点好了。叫海，然后就有了这个名字。  
- 这是一套基于socket通讯的物联网系统的解决方案。  
目前部分的物联网采集系统都用的是socket长链接来进行通讯的。它们对数据的实时性要求比较高。  
本人之前先后在两家公司物联网公司待的时候都是使用的socket长链接来进行数据采集的。  
但是目前这块的完整解决方案还在摸索当中。这个项目要要表达的只是本人自己的一个想法。  
希望对大家能有个启发的作用。

![基于Socket长链接传输的物联网采集系统-架构图](https://raw.githubusercontent.com/hanbin/sea/master/images/architecture.png)

这个图只是一个初稿，这个项目我会持续完成。但是没有deadline。因为我真的不知道什么时候能够完成。

我们假设一个场景：

> 我们有一个产品，或者这个产品是第三方的，需要不断地采集数据然后上报，频率大概是每秒上传一条。
我们的系统需要完整地接收到这些数据，并且进行初步处理。
将部分重要数据进行缓存，供客户调用，甚至要给客户推送。  
最后，所有的数据都应该进行持久化。 

这个系统就是基于上面的这个背景。


