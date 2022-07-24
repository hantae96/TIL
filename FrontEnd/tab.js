// 첫번째 버튼을 누르면
// orange 클래스 부착 인데 기존 orage 클래스는 제거
// div 박스를 보여줘야됨 show 클래스 부착


for(var j = 0; j<3; j++){

    document.querySelectorAll('.tab-button')[j].addEventListener('click',function(){
        for(var i = 0; i<3;i++){
            document.querySelectorAll('.tab-button')[i].classList.remove('orange');
            document.querySelectorAll('.tab-button')[i].classList.remove('show');
    }
    document.querySelectorAll('.tab-button')[j].classList.add('orange');
    document.querySelectorAll('.tab-button')[j].classList.add('show');
        })
    }

    // document.querySelectorAll('.tab-button')[1].addEventListener('click',function(){
    //     for(var i = 0; i<3;i++){
    //         document.querySelectorAll('.tab-button')[i].classList.remove('orange');
    //         document.querySelectorAll('.tab-button')[i].classList.remove('show');
    //     }
    //     document.querySelectorAll('.tab-button')[1].classList.add('orange');
    //     document.querySelectorAll('.tab-button')[1].classList.add('show');
    //     })

    //     document.querySelectorAll('.tab-button')[2].addEventListener('click',function(){
    //         for(var i = 0; i<3;i++){
    //             document.querySelectorAll('.tab-button')[i].classList.remove('orange');
    //             document.querySelectorAll('.tab-button')[i].classList.remove('show');
    //     }
    //     document.querySelectorAll('.tab-button')[2].classList.add('orange');
    //     document.querySelectorAll('.tab-button')[2].classList.add('show');
    //     })






// $('.tab-button').eq(0).on('click',function(){
//     $('.tab-button').removeClass('orange');
//     $('.tab-button').eq(0).addClass('orange');
//     $('.tab-button').removeClass('show');
//     $('.tab-button').eq(0).addClass('show');
// })


// $('.tab-button').eq(1).on('click',function(){
//     $('.tab-button').removeClass('orange');
//     $('.tab-button').eq(1).addClass('orange');
//     $('.tab-button').removeClass('show');
//     $('.tab-button').eq(1).addClass('show');
// })


// $('.tab-button').eq(2).on('click',function(){
//     $('.tab-button').removeClass('orange');
//     $('.tab-button').eq(2).addClass('orange');
//     $('.tab-button').removeClass('show');
//     $('.tab-button').eq(2).addClass('show');
// })