# We strongly recommend using the required_providers block to set the
# Azure Provider source and version being used
terraform {
  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
      version = "=3.0.0"
    }
  }
}

# Configure the Microsoft Azure Provider
provider "azurerm" {
  features {}

   subscription_id = "49c29c5b-863f-43c2-ae40-56e55cee24d3"
}

# Create a resource group
resource "azurerm_resource_group" "terraform_rg" {
  name     = "terraform_rg"
  location = "West Europe"
}

