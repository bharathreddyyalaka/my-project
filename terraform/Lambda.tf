data "aws_iam_policy_document" "assume_role" {
  statement {
    effect = "Allow"

    principals {
      type        = "Service"
      identifiers = ["lambda.amazonaws.com"]
    }

    actions = ["sts:AssumeRole"]
  }
}

resource "aws_iam_role" "iam_for_lambda" {
  name               = "iam_for_lambda"
  assume_role_policy = data.aws_iam_policy_document.assume_role.json

}

#data "archive_file" "lambda" {
#  type        = "zip"
#  source_file = "/Users/bharathreddyyalaka/Desktop/myproject/src/main/java/com/example/App.java"
#  output_path = "/Users/bharathreddyyalaka/Desktop/myproject/output/lambda_function_payload.zip"
#}

resource "aws_lambda_function" "demo_lambda" {
  # If the file is not in the current working directory you will need to include a
  # path.module in the filename.
  filename      = "/Users/bharathreddyyalaka/Desktop/myproject/target/myproject-1.0-SNAPSHOT.jar"
  function_name = "${local.project_name}${var.env_suffix}"
  role          = aws_iam_role.iam_for_lambda.arn
  handler       = "com.example.App::handleRequest"

  source_code_hash = local.lambda_hash

  runtime = "java17"


}

data "aws_caller_identity" "current" {}