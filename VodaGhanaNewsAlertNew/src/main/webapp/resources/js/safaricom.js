$(document).ready(function(){
				load_json_data('category');	
			
				function load_json_data(id,parent_id){
					var html_code='';
					
					$.getJSON("readJson", function (data){
						if(id=='category')
							html_code += '<option value="">Select Category</option>';
					else if(id=='subCategory')
							html_code += '<option value="">Select Sub Category</option>';
					else if(id=='mainCategory')	
							html_code += '<option value="">Select Main Category</option>';
						
						//alert(html_code);
						$.each(data.serviceList,function(key,value){
							if(id=='category'){
								if(value.parent_id==0){
									html_code += '<option value="'+value.id+'">'+value.name+'</option>';			
								}
							}else{
								if(value.parent_id==parent_id){
									html_code += '<option value="'+value.id+'">'+value.name+'</option>';
								}
							}
						});
						$('#'+id).html(html_code);
					});	
				}
				$(document).on('change','#category',function(){
					var category_id=$(this).val();
					//alert (category_id);
					if(category_id != ''){
						load_json_data('mainCategory',category_id);
					}else{
						
						$('#mainCategory').html('<option value="">Select Main Category</option>');
						$('#subCategory').html('<option value="">Select Sub Category</option>');
						
					}
					
				});
				$(document).on('change','#mainCategory',function(){
					var mainCategory_id=$(this).val();
					if(mainCategory_id!=''){
						load_json_data('subCategory',mainCategory_id);
					}else{
						$('#subCategory').html('<option value="">Select Sub Category</option>');
					}
				});
			});