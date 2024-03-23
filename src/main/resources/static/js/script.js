function promptDelete(message, url) {

        swal.fire({
                title: message,
                icon: "warning",
                showCancelButton: true,
                confirmButtonColor: "#3085d6",
                cancelButtonColor: "#d33",
                confirmButtonText: "Yes, delete it!",
                showCloseButton: true
        })
                .then((result) => {
                        if (result.isConfirmed) {
                                window.location.href = url;
                        }
                });

}