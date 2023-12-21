locals {
  lambda_filename = "/Users/bharathreddyyalaka/Desktop/myproject/target/myproject-1.0-SNAPSHOT.jar"
  lambda_hash = "base65sha256(file(${local.lambda_filename}))"
  project_name = "my-terraform-project"
  account_id = data.aws_caller_identity.current.account_id
}