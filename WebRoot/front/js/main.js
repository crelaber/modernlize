
/*
window.onload=function showtable(){
var tablename=document.getElementById("mytable");
var li=tablename.getElementsByTagName("tr");
for (var i=0;i<=li.length;i++){
if (i%2==0){
li[i].style.backgroundColor="#f0fbff";
}else li[i].style.backgroundColor="#FFFFFF";
}
}*/

$(function() {
	
	$('#faq_type_tree').tree({
		url:actual_base_path+'enterprise/urFaqTypeExt_getAllTreeNodelist?requestType=1',
		//animate:true,
		//dnd:true,
		lines : true,
		onlyLeafCheck:true,
		onClick: function(node){
	           var isLeaf = $(this).tree('isLeaf', node.target);
	           if (!isLeaf){
	        	   return false;
	           }
			 $.messager.alert('提示',"你点击了"+node.text);
           //$(this).tree('beginEdit',node.target);
        }
	});
});


function dirdisplay01()
{
    var dir = document.getElementById("dir01");
    if(dir.style.display=="none")
    {closeAll();
        dir.style.display = "block";
    }
    else if(dir.style.display =="block")
    {
        dir.style.display = "none";
    }
}
function dirdisplay02()
{
    var dir = document.getElementById("dir02");
    if(dir.style.display=="none")
    {closeAll();
        dir.style.display = "block";
    }
    else if(dir.style.display =="block")
    {
        dir.style.display = "none";
    }
}
function dirdisplay03()
{
    var dir = document.getElementById("dir03");
    if(dir.style.display=="none")
    {closeAll();
        dir.style.display = "block";
    }
    else if(dir.style.display =="block")
    {
        dir.style.display = "none";
    }
}
function dirdisplay04()
{
    var dir = document.getElementById("dir04");
    if(dir.style.display=="none")
    {closeAll();
        dir.style.display = "block";
    }
    else if(dir.style.display =="block")
    {
        dir.style.display = "none";
    }
}
function dirdisplay05()
{
    var dir = document.getElementById("dir05");
    if(dir.style.display=="none")
    {closeAll();
        dir.style.display = "block";
    }
    else if(dir.style.display =="block")
    {
        dir.style.display = "none";
    }
}
function dirdisplay06()
{
    var dir = document.getElementById("dir06");
    if(dir.style.display=="none")
    {closeAll();
        dir.style.display = "block";
    }
    else if(dir.style.display =="block")
    {
        dir.style.display = "none";
    }
}
function dirdisplay07()
{
    var dir = document.getElementById("dir07");
    if(dir.style.display=="none")
    {closeAll();
        dir.style.display = "block";
    }
    else if(dir.style.display =="block")
    {
        dir.style.display = "none";
    }
}
function dirdisplay08()
{
    var dir = document.getElementById("dir08");
    if(dir.style.display=="none")
    {closeAll();
        dir.style.display = "block";
    }
    else if(dir.style.display =="block")
    {
        dir.style.display = "none";
    }
}
function dirdisplay09()
{
    var dir = document.getElementById("dir09");
    if(dir.style.display=="none")
    {closeAll();
        dir.style.display = "block";
    }
    else if(dir.style.display =="block")
    {
        dir.style.display = "none";
    }
}
function dirdisplay10()
{
    var dir = document.getElementById("dir10");
    if(dir.style.display=="none")
    {closeAll();
        dir.style.display = "block";
    }
    else if(dir.style.display =="block")
    {
        dir.style.display = "none";
    }
}

function closeAll(){
          var oo=document.getElementsByTagName("h1");
           for (var i = 0; i < oo.length; i++){
              if (oo[i].getAttribute("class") == "jobs_notes"){
                 oo[i].style.display = "none";
                }
           }
}

function showlayer1() {
	document.getElementById("thelayer1").style.display ='block';
}

function hidediv1() {
	document.getElementById("thelayer1").style.display ='none';
}


function showlayer2() {
	document.getElementById("thelayer2").style.display ='block';
}

function hidediv2() {
	document.getElementById("thelayer2").style.display ='none';
}


function showlayer3() {
	document.getElementById("thelayer3").style.display ='block';
}

function hidediv3() {
	document.getElementById("thelayer3").style.display ='none';
}

function showlayer4() {
	document.getElementById("thelayer4").style.display ='block';
}

function hidediv4() {
	document.getElementById("thelayer4").style.display ='none';
}


function showlayer5() {
	document.getElementById("thelayer5").style.display ='block';
}

function hidediv5() {
	document.getElementById("thelayer5").style.display ='none';
}


function showlayer6() {
	document.getElementById("thelayer6").style.display ='block';
}

function hidediv6() {
	document.getElementById("thelayer6").style.display ='none';
}


function showlayer7() {
	document.getElementById("thelayer7").style.display ='block';
}

function hidediv7() {
	document.getElementById("thelayer7").style.display ='none';
}


function showlayer8() {
	document.getElementById("thelayer8").style.display ='block';
}

function hidediv8() {
	document.getElementById("thelayer8").style.display ='none';
}

function showlayer9() {
	document.getElementById("thelayer9").style.display ='block';
}

function hidediv9() {
	document.getElementById("thelayer9").style.display ='none';
}


function showlayer10() {
	document.getElementById("thelayer10").style.display ='block';
}

function hidediv10() {
	document.getElementById("thelayer10").style.display ='none';
}


function openwin1() {
	document.getElementById("openwin1").style.display ='block';
	document.getElementById("pop_grey").style.display="block";
}

function hidewin1() {
	document.getElementById("openwin1").style.display ='none';
	document.getElementById("pop_grey").style.display="none";
}
function openwin2() {
	document.getElementById("openwin2").style.display ='block';
	document.getElementById("pop_grey").style.display="block";
}

function hidewin2() {
	document.getElementById("openwin2").style.display ='none';
	document.getElementById("pop_grey").style.display="none";
}
function openwin3() {
	document.getElementById("openwin3").style.display ='block';
	document.getElementById("pop_grey").style.display="block";
}

function hidewin3() {
	document.getElementById("openwin3").style.display ='none';
	document.getElementById("pop_grey").style.display="none";
}

