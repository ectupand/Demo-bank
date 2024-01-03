
$(document).ready(function() {
    $('#clients-list').on('change', function () {
    $.ajax({
        url: "/bank-api/account/?name="+this.value,
        dataType: "json",
        success: function (data) {
            $('#account-info').empty();
            $.each(data, function(index, element) {
                $('#account-info').append($('<span>', {
                    text: element.balance + 'V\t'
                }));
            });
        }

    })
    })
        /*
        success: function () {
            //$("#account-info").load("accountInfo.html");
            $("#account-info").empty();
            $.each(data, function (key, value) {
                $("#account-info").append($("<p>").text(value.childId + ": " + value.value));
            });
            $("#myModalRead").modal('show');
        }
        */
});