resource "aws_api_gateway_rest_api" "myFirstTerraformAPI" {
  name        = "myFirstTerraformAPI"
  description = "This is my API from terraform"
}

resource "aws_api_gateway_resource" "MyFirstTerraformResource" {
  rest_api_id = aws_api_gateway_rest_api.myFirstTerraformAPI.id
  parent_id   = aws_api_gateway_rest_api.myFirstTerraformAPI.root_resource_id
  path_part   = "myterraformresource"
}

resource "aws_api_gateway_method" "MyFirstTerraformMethod" {
  rest_api_id   = aws_api_gateway_rest_api.myFirstTerraformAPI.id
  resource_id   = aws_api_gateway_resource.MyFirstTerraformResource.id
  http_method   = "GET"
  authorization = "NONE"
}

resource "aws_api_gateway_integration" "integration" {
  rest_api_id             = aws_api_gateway_rest_api.myFirstTerraformAPI.id
  resource_id             = aws_api_gateway_resource.MyFirstTerraformResource.id
  http_method             = aws_api_gateway_method.MyFirstTerraformMethod.http_method
  integration_http_method = "POST"
  type                    = "AWS_PROXY"
  uri                     = aws_lambda_function.demo_lambda.invoke_arn
}

resource "aws_lambda_permission" "apigw_lambda" {
  statement_id  = "AllowExecutionFromAPIGateway"
  action        = "lambda:InvokeFunction"
  function_name = aws_lambda_function.demo_lambda.function_name
  principal     = "apigateway.amazonaws.com"

  # More: http://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-control-access-using-iam-policies-to-invoke-api.html
  source_arn = "arn:aws:execute-api:${var.region}:${local.account_id}:${aws_api_gateway_rest_api.myFirstTerraformAPI.id}/*/${aws_api_gateway_method.MyFirstTerraformMethod.http_method}${aws_api_gateway_resource.MyFirstTerraformResource.path}"
}

#resource "aws_api_gateway_integration" "MyDemoIntegration" {
#  rest_api_id          = aws_api_gateway_rest_api.MyDemoAPI.id
#  resource_id          = aws_api_gateway_resource.MyDemoResource.id
#  http_method          = aws_api_gateway_method.MyDemoMethod.http_method
#  type                 = "MOCK"
#  cache_key_parameters = ["method.request.path.param"]
#  cache_namespace      = "foobar"
#  timeout_milliseconds = 29000
#
#  request_parameters = {
#    "integration.request.header.X-Authorization" = "'static'"
#  }
#
#  # Transforms the incoming XML request to JSON
#  request_templates = {
#    "application/xml" = <<EOF
#{
#   "body" : $input.json('$')
#}
#EOF
#  }
#}

