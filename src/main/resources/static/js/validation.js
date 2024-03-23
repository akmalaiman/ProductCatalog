function validateInput(input, message) {

        try {

                var inputTargetStatus = input.name + "Status";

                with (input) {

                        if (input.value == "") {
                                document.getElementById(inputTargetStatus).innerHTML = message;
                                return false;
                        } else {
                                document.getElementById(inputTargetStatus).innerHTML = "";
                                return true;
                        }

                }

        } catch (e) {
                console.log("Error in validateInput: " + e);
                return false;
        }

}

function validateAddProduct(thisform) {

        try {

                var isValid = true;

                with (thisform) {

                        if (!validateInput(code, "Please enter a product code.")) {
                                isValid = false;
                        }

                        if (!validateInput(name, "Please enter a product name.")) {
                                isValid = false;
                        }

                        if (!validateInput(category, "Please enter a product category.")) {
                                isValid = false;
                        }

                        if (!validateInput(brand, "Please enter a product brand.")) {
                                isValid = false;
                        }

                        if (!validateInput(type, "Please enter a product type.")) {
                                isValid = false;
                        }

                        if (!validateInput(description, "Please enter a product description.")) {
                                isValid = false;
                        }

                }

                return isValid;

        } catch {
                console.log("Error in validateAddProduct: " + e);
                return false;
        }

}

function validateEditProduct(thisform) {

        try {

                var isValid = true;

                with (thisform) {

                        if (!validateInput(name, "Please enter a product name.")) {
                                isValid = false;
                        }

                        if (!validateInput(category, "Please enter a product category.")) {
                                isValid = false;
                        }

                        if (!validateInput(brand, "Please enter a product brand.")) {
                                isValid = false;
                        }

                        if (!validateInput(type, "Please enter a product type.")) {
                                isValid = false;
                        }

                        if (!validateInput(description, "Please enter a product description.")) {
                                isValid = false;
                        }

                }

                return isValid;

        } catch {
                console.log("Error in validateAddProduct: " + e);
                return false;
        }

}