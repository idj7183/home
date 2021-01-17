var main={
    init : function(){

        var list = $('#list').val();
        var data = [];
        var cnt = 0;

        var cst = -1;
        for(var i =0;i<list.length;i++){

            var tmp = list[i].charCodeAt(0);

            if(tmp>=48 && tmp<=57){
                if(cst==-1){
                    cst = list[i];
                }
                else{
                    cst = cst+list[i];
                }
            }
            else{
                if(cst!=-1){
                    data[cnt] = cst;
                    console.log(data[cnt]);
                    cnt++;
                    cst = -1;
                }
            }
        }

        var step;
        var date = [];

        for(step=0;step<7;step++){
            var nowDate = new Date();

            var yesterday = nowDate.getTime() - (step*24*60*60*1000)

            nowDate.setTime(yesterday);

            if(nowDate.getMonth()+1<10){
                date[step] = '0'+(nowDate.getMonth()+1)+'/'+(nowDate.getDate());
            }
            else{
                date[step] = (nowDate.getMonth()+1)+'/'+(nowDate.getDate());
            }
        }

        var ctx = document.getElementById('myChart').getContext('2d');
        var chart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: [date[6], date[5], date[4], date[3], date[2], date[1], date[0]],
                datasets: [
                   { label: 'Visitors', backgroundColor: 'transparent', borderColor: 'blue', data: [data[6], data[5], data[4], data[3], data[2], data[1], data[0]] },
                ]
            },
            options: {}
        });
    }
}

main.init();