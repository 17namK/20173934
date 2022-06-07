var width = 4;
var heigth = 3;
var colorList = [];
var color = [];
var clickFlag = true; //처음 세팅 중 클릭불가
var clickCard = [];
var completeCard = [];
var startTime;

function suffle() {
	for (let i = 0; colorList.length > 0; i++) {
		color = color.concat(
			colorList.splice(Math.floor(Math.random() * colorList.length), 1),
		);
		console.log('셔플 진행', color[i]);
	}
}
function setting() {
	document.querySelector('#wrapper').innerHTML = '';
	color = [];
	colorList = [
		'red',
		'red',
		'orange',
		'orange',
		'green',
		'green',
		'yellow',
		'yellow',
		'white',
		'white',
		'pink',
		'pink',
	];
	completeCard = [];
}

function cardSetting(width_2, hiegth_2) {
	clickFlag = false;
	for (let i = 0; i < width_2 * hiegth_2; i++) {
		var card = document.createElement('div');
		card.className = 'card';

		var cardInner = document.createElement('div');
		cardInner.className = 'card_inner';

		var cardFront = document.createElement('div');
		cardFront.className = 'card_front';

		var cardBack = document.createElement('div');
		cardBack.className = 'card_back';

		//랜덤한 색 지정
		suffle();
		console.log(color[i]);
		cardBack.style.backgroundColor = color[i];
		cardInner.appendChild(cardFront);
		cardInner.appendChild(cardBack);
		card.appendChild(cardInner);

		//클로저 문제 해결
		(function (c) {
			c.addEventListener('click', function (e) {
				if (clickFlag && !completeCard.includes(c)) {
					//includes 는 내부에 매개변수가 존재하는지 검사
					c.classList.toggle('flipped');
					clickCard.push(c);
					if (clickCard.length === 2) {
						if (
							clickCard[0].querySelector('.card_back').style
								.backgroundColor ===
								clickCard[1].querySelector('.card_back').style
									.backgroundColor &&
							clickCard[0].className === 'card flipped'
						) {
							completeCard.push(clickCard[0]);
							completeCard.push(clickCard[1]);
							clickCard = [];
							if (completeCard.length === width_2 * hiegth_2) {
								var endTime = new Date();
								var wrapTime = (endTime - startTime) / 1000;
								console.log(endTime, startTime, wrapTime);
								setTimeout(() => {
									alert(wrapTime + ' 초만에 성공!');
									setting();
									cardSetting(width, heigth);
								}, 1000);
							}
						} else {
							clickFlag = false;
							setTimeout(() => {
								clickCard[0].classList.remove('flipped');
								clickCard[1].classList.remove('flipped');
								clickFlag = true;
								clickCard = [];
							}, 1000);
						}
					}
				}
			});
		})(card);
		document.querySelector('#wrapper').appendChild(card);
	}
	//처음 시작할 때 카드를 외울 수 있게 도움
	document.querySelectorAll('.card').forEach((card, index) => {
		setTimeout(function () {
			card.classList.add('flipped');
			clickFlag = false;
		}, 1000 + 100 * index);
		setTimeout(function () {
			card.classList.remove('flipped');
			clickFlag = true;
			startTime = new Date();
		}, 5000);
	});
}
setting();
cardSetting(width, heigth);
