var main2={
    init: function(){
        var _this = this;
        $('#click').on('click',function(){
            var result = confirm('정말로 변경하시겠습니까?')
            if(result){
                _this.send();
            }
            else{
                window.location.href='/admin';
            }
        }),
        $(document).ready(function(){
            $('#usr').keydown(function(key){
                if(key.keyCode==13){
                     var result = confirm('정말로 변경하시겠습니까?')

                     if(result){
                         _this.send();
                     }
                     else{
                        window.location.href='/admin';
                     }
                }
            })
        })
    },
    send : function(){
         var data = {
           name: $('#usr').val()
         }
         $.ajax({
              type: 'POST',
              url: '/admin/user',
              dataType: 'json',
              contentType:'application/json; charset=utf-8',
              data: JSON.stringify(data)
         }).done(function(){
              alert('권한이 변경되었습니다!');
              window.location.href='/admin';
         }).fail(function(error){
              alert(JSON.stringify(error));
              window.location.href='/admin';
         })
    }
}

main2.init();