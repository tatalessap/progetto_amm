function createElement(utente){
    var img = $("<img>")
            .attr("alt","foto profilo amico")
            .attr("class", "immagine");
    
    if(utente.url == null || utente.url === "")
        img.attr("src", "img/immagine.png");     
    else img.attr("src", utente.url);
    
    var name = $("<a>")
            .append(img)
            .attr("href", "bacheca.html?postvisualizati=true&idOtherUser="+utente.personalID)
            .append(utente.nomeUtente+" "+utente.cognomeUtente);
    
    return $("<li>").append(name);
    
    
}

function stateSuccess(data){
    var utente = $("#personeListaRicerca");
    
    $(utente).empty();
    for(var instance in data){
        $(utente).append(createElement(data[instance]));
    }
}
function stateFailure(data, state){
    
     console.log("failure");
    $("#personeListaRicerca ul").empty();    
    $("#personeListaRicerca ul").append($("<li>").append("Nessun risultato"));    
}

$(document).ready(function(){
    $("#searchBottone").click(function(){
        
        var utenteCercato = $("#searchAmico")[0].value;
        
        $.ajax({
            url: "Filter",
            data:{
                cmd:"search",
                cercaUtente: utenteCercato
            },
            dataType:"json",
            success: function(data, state){
                stateSuccess(data)
            },
            error: function(data, state){
                stateFailure(data, state)
            }
        });
    })
});

function resaListaDinamica()
{
    var utenteCercato = $("#searchAmico")[0].value;
        
        $.ajax({
            url: "Filter",
            data:{
                cmd:"search",
                cercaUtente: utenteCercato
            },
        dataType:"json",
        success: function(data, state){
            stateSuccess(data);
        },
        error: function(data, state){
            stateFailure(data, state);
        }
    });

}