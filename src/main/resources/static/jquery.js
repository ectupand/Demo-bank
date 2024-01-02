

window.addEventListener('change', (e) => {
    var clientsList = document.getElementById('clients-list');
    console.log(`e.target.value = ${ e.target.value }`);
    console.log(`activities.options[activities.selectedIndex].value = ${ clientsList.options[clientsList.selectedIndex].value }`);

    $.ajax({
        url: "/bank-api/account/?name="+e.target.value,
        dataType: "json",
        success: function () {
            document.getElementById('account-info').style.display = 'block';
        }
    })
});
