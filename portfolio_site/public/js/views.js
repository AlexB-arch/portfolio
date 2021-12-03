/* DOM */
const menuToggle = document.getElementById('mobile-menu-toggle');

menuToggle.addEventListener('click', function () {
    let menu = document.getElementById('mobile-menu');

    if(menu.classList.contains('hidden')){
        menu.classList.remove('hidden');
    }
    else{
        menu.classList.add('hidden');
    }
});