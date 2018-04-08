$(function(){
  $('.timeset1').datetimepicker();
  $('.timeset2').datetimepicker();
	$('.opendoor').click(function(){
		// $('#status').html('开启状态');
    var status=$(".selectpicker").val();
		$.MsgBox.Alert('Tips','设置成功！');
    $(".xiugai").html(status);
	});

	var defaultData = [
          {
            text: '东大门',
            href: '#parent1',
            tags: ['2'],
            nodes: [
              {
                text: '东1门',
                href: '#child1',
                tags: ['0']
              },
              {
                text: '东2门',
                href: '#child2',
                tags: ['0']
              }
            ]
          },
          {
            text: '南大门',
            href: '#parent1',
            tags: ['4'],
            nodes: [
              {
                text: '南1门',
                href: '#child1',
                tags: ['2'],
                nodes: [
                  {
                    text: '南1小门1',
                    href: '#grandchild1',
                    tags: ['0']
                  },
                  {
                    text: '南1小门2',
                    href: '#grandchild2',
                    tags: ['0']
                  }
                ]
              },
              {
                text: '南2门',
                href: '#child2',
                tags: ['0']
              }
            ]
          },
          {
            text: '西大门',
            href: '#parent1',
            tags: ['2'],
            nodes: [
              {
                text: '西1门',
                href: '#child1',
                tags: ['0']
              },
              {
                text: '西2门',
                href: '#child2',
                tags: ['0']
              }
            ]
          },
          {
            text: '北大门',
            href: '#parent1',
            tags: ['2']
          },
          {
            text: '天馨园',
            href: '#parent1',
            tags: ['4'],
            nodes: [
              {
                text: '1栋门',
                href: '#child1',
                tags: ['0']
              },
              {
                text: '2栋门',
                href: '#child2',
                tags: ['0']
              },
              {
                text: '3栋门',
                href: '#child3',
                tags: ['0']
              },
              {
                text: '4栋门',
                href: '#child4',
                tags: ['0']
              }
            ]
          },
          {
            text: '天怡园',
            href: '#parent1',
            tags: ['4'],
            nodes: [
              {
                text: '5栋门',
                href: '#child1',
                tags: ['0']
              },
              {
                text: '6栋门',
                href: '#child2',
                tags: ['0']
              },
              {
                text: '7栋门',
                href: '#child3',
                tags: ['0']
              },
              {
                text: '8栋门',
                href: '#child4',
                tags: ['0']
              }
            ]
          },
          {
            text: '天美园',
            href: '#parent1',
            tags: ['4'],
            nodes: [
              {
                text: '9栋门',
                href: '#child1',
                tags: ['0']
              },
              {
                text: '10栋门',
                href: '#child2',
                tags: ['0']
              },
              {
                text: '11栋门',
                href: '#child3',
                tags: ['0']
              },
              {
                text: '12栋门',
                href: '#child4',
                tags: ['0']
              }
            ]
          }
        ];
	$('#treeview1').treeview({
          data: defaultData
        });
});