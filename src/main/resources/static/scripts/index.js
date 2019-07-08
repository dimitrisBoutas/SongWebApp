/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function openUploadForm() {
    document.querySelector("#id01").style.display = 'block';
}
function closeUploadForm() {
    document.querySelector("#id01").style.display = 'none';
}
window.onclick = function (event) {
    if (event.target == document.querySelector("#id01")) {
        closeUploadForm();
    }
}


