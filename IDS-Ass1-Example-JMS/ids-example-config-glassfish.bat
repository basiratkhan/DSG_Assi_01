echo [Config] Starting Glassfish:
call asadmin start-domain
echo [Config] Set JMS_DEFAULT_HOST to %1:
call asadmin set configs.config.server-config.jms-service.jms-host.default_JMS_host.host=%1
echo [Config] Creating JMS Resource: ConnectionFactory with Name "jms/IdsExampleConnectionFactory":
call asadmin create-jms-resource --restype javax.jms.ConnectionFactory --description "Connection Factory for JMS Example" jms/IdsExampleConnectionFactory

echo [Config] Creating JMS Resource: Queue with Name "jms/IdsExampleQueue":
call asadmin create-jms-resource --restype javax.jms.Queue --property Name=IdsExampleQueue jms/IdsExampleQueue

if errorlevel 1 (
  color 4f
   echo.
   echo [Config] Something went wrong - check error message above
) else (
  color 2f
  echo.
  echo [Config] Success.
)