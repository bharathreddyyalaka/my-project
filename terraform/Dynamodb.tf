resource "aws_dynamodb_table" "basic-dynamodb-table" {
  name           = "${local.project_name}${var.ddb_name}${var.env_suffix}"
  billing_mode   = "PROVISIONED"
  read_capacity  = 5
  write_capacity = 5
  hash_key       = "UserId"


  attribute {
    name = "UserId"
    type = "S"
  }

}

output "ddb_outputs" {
  value = aws_dynamodb_table.basic-dynamodb-table.arn

}

data "aws_dynamodb_table" "random-table" {
  name = "my-first-table"
}

output "previous-table" {
  value = data.aws_dynamodb_table.random-table.arn
}