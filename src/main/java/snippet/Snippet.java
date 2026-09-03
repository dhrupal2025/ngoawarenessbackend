package snippet;

public class Snippet {
	HTTP Status 500 – Internal Server Error
	Type Exception Report
	
	Message Request processing failed: org.hibernate.exception.SQLGrammarException: JDBC exception executing SQL [select p1_0.id,p1_0.category,p1_0.description,p1_0.imageUrl,p1_0.price,p1_0.productName from products p1_0] [Unknown column 'p1_0.imageUrl' in 'field list'] [n/a]
	
	Description The server encountered an unexpected condition that prevented it from fulfilling the request.
	
	Exception
	
	jakarta.servlet.ServletException: Request processing failed: org.hibernate.exception.SQLGrammarException: JDBC exception executing SQL [select p1_0.id,p1_0.category,p1_0.description,p1_0.imageUrl,p1_0.price,p1_0.productName from products p1_0] [Unknown column 'p1_0.imageUrl' in 'field list'] [n/a]
		org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1022)
		org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:903)
		jakarta.servlet.http.HttpServlet.service(HttpServlet.java:564)
		org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885)
		jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
		org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51)
	Root Cause
	
	org.hibernate.exception.SQLGrammarException: JDBC exception executing SQL [select p1_0.id,p1_0.category,p1_0.description,p1_0.imageUrl,p1_0.price,p1_0.productName from products p1_0] [Unknown column 'p1_0.imageUrl' in 'field list'] [n/a]
		org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:66)
		org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
		org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
		org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:94)
		org.hibernate.sql.results.jdbc.internal.DeferredResultSetAccess.executeQuery(DeferredResultSetAccess.java:269)
		org.hibernate.sql.results.jdbc.internal.DeferredResultSetAccess.getResultSet(DeferredResultSetAccess.java:172)
		org.hibernate.sql.results.jdbc.internal.JdbcValuesResultSetImpl.<init>(JdbcValuesResultSetImpl.java:74)
		org.hibernate.sql.exec.internal.JdbcSelectExecutorStandardImpl.resolveJdbcValuesSource(JdbcSelectExecutorStandardImpl.java:355)
		org.hibernate.sql.exec.internal.JdbcSelectExecutorStandardImpl.doExecuteQuery(JdbcSelectExecutorStandardImpl.java:137)
		org.hibernate.sql.exec.internal.JdbcSelectExecutorStandardImpl.executeQuery(JdbcSelectExecutorStandardImpl.java:102)
		org.hibernate.sql.exec.spi.JdbcSelectExecutor.executeQuery(JdbcSelectExecutor.java:91)
		org.hibernate.sql.exec.spi.JdbcSelectExecutor.list(JdbcSelectExecutor.java:165)
		org.hibernate.query.sqm.internal.ConcreteSqmSelectQueryPlan.lambda$new$1(ConcreteSqmSelectQueryPlan.java:152)
		org.hibernate.query.sqm.internal.ConcreteSqmSelectQueryPlan.withCacheableSqmInterpretation(ConcreteSqmSelectQueryPlan.java:442)
		org.hibernate.query.sqm.internal.ConcreteSqmSelectQueryPlan.performList(ConcreteSqmSelectQueryPlan.java:362)
		org.hibernate.query.sqm.internal.QuerySqmImpl.doList(QuerySqmImpl.java:380)
		org.hibernate.query.spi.AbstractSelectionQuery.list(AbstractSelectionQuery.java:143)
		com.mvc.jewellerysystem.daoimpl.ProductDaoImpl.getAllProducts(ProductDaoImpl.java:108)
		com.mvc.jewellerysystem.serviceimpl.ProductServiceImpl.getAllProducts(ProductServiceImpl.java:40)
		com.mvc.jewellerysystem.controller.AdminController.dashboard(AdminController.java:43)
		java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
		java.base/java.lang.reflect.Method.invoke(Method.java:580)
		org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:258)
		org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:191)
		org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:118)
		org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:986)
		org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:891)
		org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
		org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1089)
		org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:979)
		org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1014)
		org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:903)
		jakarta.servlet.http.HttpServlet.service(HttpServlet.java:564)
		org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885)
		jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
		org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51)
	Root Cause
	
	java.sql.SQLSyntaxErrorException: Unknown column 'p1_0.imageUrl' in 'field list'
		com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:112)
		com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:114)
		com.mysql.cj.jdbc.ClientPreparedStatement.executeInternal(ClientPreparedStatement.java:988)
		com.mysql.cj.jdbc.ClientPreparedStatement.executeQuery(ClientPreparedStatement.java:1056)
		org.hibernate.sql.results.jdbc.internal.DeferredResultSetAccess.executeQuery(DeferredResultSetAccess.java:251)
		org.hibernate.sql.results.jdbc.internal.DeferredResultSetAccess.getResultSet(DeferredResultSetAccess.java:172)
		org.hibernate.sql.results.jdbc.internal.JdbcValuesResultSetImpl.<init>(JdbcValuesResultSetImpl.java:74)
		org.hibernate.sql.exec.internal.JdbcSelectExecutorStandardImpl.resolveJdbcValuesSource(JdbcSelectExecutorStandardImpl.java:355)
		org.hibernate.sql.exec.internal.JdbcSelectExecutorStandardImpl.doExecuteQuery(JdbcSelectExecutorStandardImpl.java:137)
		org.hibernate.sql.exec.internal.JdbcSelectExecutorStandardImpl.executeQuery(JdbcSelectExecutorStandardImpl.java:102)
		org.hibernate.sql.exec.spi.JdbcSelectExecutor.executeQuery(JdbcSelectExecutor.java:91)
		org.hibernate.sql.exec.spi.JdbcSelectExecutor.list(JdbcSelectExecutor.java:165)
		org.hibernate.query.sqm.internal.ConcreteSqmSelectQueryPlan.lambda$new$1(ConcreteSqmSelectQueryPlan.java:152)
		org.hibernate.query.sqm.internal.ConcreteSqmSelectQueryPlan.withCacheableSqmInterpretation(ConcreteSqmSelectQueryPlan.java:442)
		org.hibernate.query.sqm.internal.ConcreteSqmSelectQueryPlan.performList(ConcreteSqmSelectQueryPlan.java:362)
		org.hibernate.query.sqm.internal.QuerySqmImpl.doList(QuerySqmImpl.java:380)
		org.hibernate.query.spi.AbstractSelectionQuery.list(AbstractSelectionQuery.java:143)
		com.mvc.jewellerysystem.daoimpl.ProductDaoImpl.getAllProducts(ProductDaoImpl.java:108)
		com.mvc.jewellerysystem.serviceimpl.ProductServiceImpl.getAllProducts(ProductServiceImpl.java:40)
		com.mvc.jewellerysystem.controller.AdminController.dashboard(AdminController.java:43)
		java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
		java.base/java.lang.reflect.Method.invoke(Method.java:580)
		org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:258)
		org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:191)
		org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:118)
		org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:986)
		org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:891)
		org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
		org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1089)
		org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:979)
		org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1014)
		org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:903)
		jakarta.servlet.http.HttpServlet.service(HttpServlet.java:564)
		org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885)
		jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
		org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51)
	Note The full stack trace of the root cause is available in the server logs.
	
	Apache Tomcat/10.1.52
}

