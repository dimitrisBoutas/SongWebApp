/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready( ()=>{
    
    $('.lrbtn').click(function(event){
        let id  = event.target.id;
        let c = '.'+id;
        $(c).css("display","block");
    });
    
    $('span').click( function(){
        $('.lyrics').css('display', 'none');
    });
});

