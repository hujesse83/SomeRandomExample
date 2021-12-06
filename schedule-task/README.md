## @EnableAsync@Async使用总结

1、对于Config包下的Thread配置文件

A.自定义ThreadPool

B.重写AsyncConfigurer下的getAsyncExecutor 返回Executor.

----

我们在使用多线程的时候，往往需要创建Thread类，或者实现Runnable接口，如果要使用到线程池，我们还需要来创建Executors，在使用spring中，已经给我们做了很好的支持。只要要@EnableAsync就可以使用多线程。使用@Async就可以定义一个线程任务。通过spring给我们提供的ThreadPoolTaskExecutor就可以使用线程池。

默认情况下，Spring将搜索相关的线程池定义：要么在上下文中搜索唯一的TaskExecutor bean，要么搜索名为“taskExecutor”的Executor bean。如果两者都无法解析，则将使用SimpleAsyncTaskExecutor来处理异步方法调用。

----

@Configuration用于定义配置类，被注解的类内部包含有一个或多个被@Bean注解的方法，这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描，并用于构建bean定义，初始化Spring容器。

@EnableAsync开始对异步任务的支持

----

@Async注解来声明一个或多个异步任务，可以加在方法或者类上，加在类上表示这整个类都是使用这个自定义线程池进行操作。在我这个example中，**Async不指定那个线程池，使用未指定线程池的名称使用ThreadConfigV2线程池。**