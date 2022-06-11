let curPos = 0;
let postion = 0;
const IMAGE_WIDTH = 1024;
const prevBtn = document.querySelector(".prev")
const nextBtn = document.querySelector(".next")
const images = document.querySelector(".images")
 
function prev(){
  if(curPos > 0){
    nextBtn.removeAttribute("disabled")
    postion += IMAGE_WIDTH;
    images.style.transform = `translateX(${postion}px)`;
    curPos = curPos - 1;
  }
  if(curPos == 0){
    prevBtn.setAttribute('disabled', 'true')
  }
}
function next(){
  if(curPos < 3){
    prevBtn.removeAttribute("disabled")
    postion -= IMAGE_WIDTH;
    images.style.transform = `translateX(${postion}px)`;
    curPos = curPos + 1;
  }
  if(curPos == 3){
    nextBtn.setAttribute('disabled', 'true')
  }
}
 
function init(){
  prevBtn.setAttribute('disabled', 'true')
  prevBtn.addEventListener("click", prev)
  nextBtn.addEventListener("click", next)
}
 
init();

//외부
let curPos1 = 0;
let postion1 = 0;
const IMAGE_WIDTH1 = 1024;
const prevBtn1 = document.querySelector(".prev1")
const nextBtn1 = document.querySelector(".next1")
const images1 = document.querySelector(".images1")
 
function prev1(){
  if(curPos1 > 0){
    nextBtn1.removeAttribute("disabled")
    postion1 += IMAGE_WIDTH1;
    images1.style.transform = `translateX(${postion1}px)`;
    curPos1 = curPos1 - 1;
  }
  if(curPos1 == 0){
    prevBtn1.setAttribute('disabled', 'true')
  }
}
function next1(){
  if(curPos1 < 3){
    prevBtn1.removeAttribute("disabled")
    postion1 -= IMAGE_WIDTH1;
    images1.style.transform = `translateX(${postion1}px)`;
    curPos1 = curPos1 + 1;
  }
  if(curPos1 == 3){
    nextBtn1.setAttribute('disabled', 'true')
  }
}
 
function init1(){
  prevBtn1.setAttribute('disabled', 'true')
  prevBtn1.addEventListener("click", prev1)
  nextBtn1.addEventListener("click", next1)
}
 
init1();